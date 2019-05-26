递归思路：

sum[i-1] < 0, 那么sum[i] = arr[i]
sum[i-1] >= 0, 那么sum[i] = sum[i-1] + arr[i]

代码和max+sum类似
