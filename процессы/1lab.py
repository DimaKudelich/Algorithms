import numpy as np

matrix = np.array([
    [1,3,4,5,3,2,1],
    [3,4,5,3,2,1,1],
    [4,5,3,2,1,1,3],
    [5,3,2,1,1,3,4],
    [3,2,1,1,3,4,5],
    [2,1,1,3,4,5,3],
    [1,1,3,4,5,3,2]
    ])
#processors
p = 3
#processes and blocks
n = s = 7

#finding (t1,t2,...,ts), where tj - execution time of the j-th block by each of the processes
def find_times(matrix, s):
    times = []
    i = 0

    for i in range (s):
        times.append(np.sum(matrix[i]))
    
    return times

#finding r and p from equation n = kp + r
def find_kr(n,p):
    k = int(n/p)
    r = n - k*p 

    return k,r

def Tca_ac1(p,n,s,matrix):
    times = find_times(matrix,s)
    Tc_s = np.sum(times)
    tmax_s = max(times)
    kr = find_kr(n,p)
    k = kr[0]
    r = kr[1]

    if p <= n and Tc_s <= p*tmax_s:
        res = Tc_s + (n - 1)*tmax_s
        print (Tc_s, "+", (n - 1), "*", tmax_s)
    elif n > p and Tc_s > p*tmax_s:
        res = (k + 1)*Tc_s + (r - 1)*tmax_s
        print(k + 1, "*" , Tc_s, "+", (r - 1), "*", tmax_s)    
    
    return res


def tco_2(p,n,s,matrix):
    times = find_times(matrix,s)
    Tc_s = np.sum(times)
    
    #sum of max
    sum = 0
    i = 1
    for i in range (s):
        sum += max(times[i]-times[i-1],0)

    res = Tc_s + (p-1)*(times[0] + sum)

    return res


def Tco_2(p,n,s,matrix):
    times = find_times(matrix,s)
    Tc_s = np.sum(times)
    tmax_s = max(times)
    kr = find_kr(n,p)
    k = kr[0]
    r = kr[1]

    if n == p:
        res = tco_2(p,n,s,matrix)

    elif n == k*p:
        d1 = min((p-1)*tmax_s,Tc_s-tmax_s)
        res = k*tco_2(p,n,s,matrix) - (k-1)*d1

    elif n == k*p+r:


        d2 = min((p-1)*min(times[0],times[s-1]), tco_2(p,n,s,matrix) - p*tmax_s)
        d3 = min((r-1)*min(times[0],times[s-1]) + (p-r)*times[s-1], tco_2(p,n,s,matrix) )
        res = k*tco_2(p,n,s,matrix) + tco_2(r,r,s,matrix) - (k-1)*d2 - d3 

    return res


print(Tca_ac1(p,n,s,matrix))