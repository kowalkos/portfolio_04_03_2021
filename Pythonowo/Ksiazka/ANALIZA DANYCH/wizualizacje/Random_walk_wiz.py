import matplotlib.pyplot as plt
from random_walk import RandomWalk

while True:
    rw=RandomWalk(10000)
    rw.fill_walk()
    plt.style.use('classic')
    point_numbers=range(rw.num_points)
    fig,ax=plt.subplots(figsize=(7,3),dpi=128)
    """ax.scatter(rw.x_values,rw.y_values,c=point_numbers,cmap=plt.cm.Blues,edgecolor='none',s=10)
    ax.scatter(rw.x_values[0],rw.y_values[0],c='green',edgecolors='none',s=100)
    ax.scatter(rw.x_values[-1],rw.y_values[-1],c='red',edgecolors='none',s=100)
    ax.get_xaxis().set_visible(False)
    ax.get_yaxis().set_visible(False)
    plt.show()
    keep_running=input("Utworzyć kolejne błądzenie? (t/n)?")
    if keep_running=='n':
        break"""
    ax.plot(rw.x_values,rw.y_values,c='green',linewidth=1)
    ax.get_xaxis().set_visible(False)
    ax.get_yaxis().set_visible(False)
    
    plt.show()
    keep_running=input("Utworzyć kolejne błądzenie? (t/n)?")
    if keep_running=='n':
        break
