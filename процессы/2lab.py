import numpy as np

#initial condition
O = np.array([2,2,4,2,5,3,5,7,3,2])
p = 21
n = 50
c = 3
t = 1
m = int(p/c)

#add the variable t to all elements of the array
for i in range (len(O)):
    O[i] += t

#find the variables k and r from the equation n = k*p + r (completed)
def find_kr(n,p):
    k = int(n/p)
    r = n-k*p
    return k,r

#find the execution time for asynchronous and first synchronous processes (completed)
def find_Tca_Tc1(p,n,O,c,m):
    t_max = np.max(O)
    T_c = np.sum(O)

    if (p == n or p < n) and T_c <= m*t_max:
        res = T_c + (int(n/c)-1)*t_max
    elif p < n and T_c > m*t_max:
        kr = find_kr(n,p)
        res = (kr[0] + 1)*T_c + (int(kr[1]/c) - 1)*t_max
    
    return res

#find Tc2x (completed)
def find_Tc2x(x,O):
    T_c = np.sum(O)
    d1 = find_d1(O)

    res = T_c + (x-1)*d1

    return res

#▲O(s) (completed)
def find_d1(O):
    max_O = 0
    
    for i in range (1,len(O)):
        max_O += max(O[i]-O[i-1],0)

    res = O[0] + max_O
    
    return res

#▲O(j) (completed)
def find_d2(O,j):
    max_s = 0

    for i in range (1,j+1):
        max_s += max(O[i] - O[i-1], 0) 

    res = O[0] + max_s
    
    return res

#▲(x,y) (completed)
def find_d3(x,y,O):
    max_s = 0

    for j in range (len(O)):
        t = y * O[j] + find_d2(O, j) * (x - y)
         
        if t > max_s:
            max_s = t

    res = min(
        (y - 1) * min(O[len(O)-1], O[0]) + (x - y) * O[len(O)-1], 
        find_Tc2x(x,O) - max_s
        )

    return res

#find the execution time for second synchronous processes (completed)
def find_Tc2(p,n,O,c,m):
    kr = find_kr(n,p)

    res = kr[0] * find_Tc2x(m,O) - (kr[0] - 1)*find_d3(m,m,O) + find_Tc2x(int(kr[1]/c),O) - find_d3(m,int(kr[1]/c),O)
    #print(kr[0], "*", find_Tc2x(m,O), "-" ,"(",kr[0], "-", 1,")*",find_d3(m,m,O), "+", find_Tc2x(int(kr[1]/c),O), "-", find_d3(m,int(kr[1]/c),O))
    return res

print("T_c^a = T_c^1 = ", find_Tca_Tc1(p,n,O,c,m))
print("T_c^2 = ",find_Tc2(p,n,O,c,m))

