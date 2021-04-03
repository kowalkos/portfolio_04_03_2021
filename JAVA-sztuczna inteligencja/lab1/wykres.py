import matplotlib.pyplot as plt
filename='bs.txt'
f=open(filename,'r')
f2=open("obecny.txt",'r')
a=f.read()
a2=f2.read()
y_values=a2.split('\n')

plt.style.use('seaborn')
fig,ax=plt.subplots()
ax.scatter(range(len(y_values)),y_values,s=10)
ax.axis([0,1000,-2,2])
plt.show()