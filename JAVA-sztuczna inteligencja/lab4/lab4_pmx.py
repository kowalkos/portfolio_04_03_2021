import random
import numpy as np
def twórzliste( a, b):
    tab=[i for i in range(a,b)]
    tab_zw=[]
    for i in range(len(tab)):
        indeks=random.choice(tab)
        tab_zw.append(tab.pop(tab.index(indeks)))
    print(tab_zw)
    return tab_zw
parent1=twórzliste(1,10)
parent2=twórzliste(1,10)
firstCrossPoint = np.random.randint(0,len(parent1)-2)
secondCrossPoint = np.random.randint(firstCrossPoint+1,len(parent1)-1)

print(firstCrossPoint, secondCrossPoint)

parent1MiddleCross = parent1[firstCrossPoint:secondCrossPoint]
parent2MiddleCross = parent2[firstCrossPoint:secondCrossPoint]

temp_child1 = parent1[:firstCrossPoint] + parent2MiddleCross + parent1[secondCrossPoint:]

temp_child2 = parent2[:firstCrossPoint] + parent1MiddleCross + parent2[secondCrossPoint:]

relations = []
for i in range(len(parent1MiddleCross)):
    relations.append([parent2MiddleCross[i], parent1MiddleCross[i]])

print(relations)

def recursion1 (temp_child , firstCrossPoint , secondCrossPoint , parent1MiddleCross , parent2MiddleCross) :
    child = np.array([0 for i in range(len(parent1))])
    for i,j in enumerate(temp_child[:firstCrossPoint]):
        c=0
        for x in relations:
            if j == x[0]:
                child[i]=x[1]
                c=1
                break
        if c==0:
            child[i]=j
    j=0
    for i in range(firstCrossPoint,secondCrossPoint):
        child[i]=parent2MiddleCross[j]
        j+=1

    for i,j in enumerate(temp_child[secondCrossPoint:]):
        c=0
        for x in relations:
            if j == x[0]:
                child[i+secondCrossPoint]=x[1]
                c=1
                break
        if c==0:
            child[i+secondCrossPoint]=j
    child_unique=np.unique(child)
    if len(child)>len(child_unique):
        child=recursion1(child,firstCrossPoint,secondCrossPoint,parent1MiddleCross,parent2MiddleCross)
    return(child)

def recursion2(temp_child,firstCrossPoint,secondCrossPoint,parent1MiddleCross,parent2MiddleCross):
    child = np.array([0 for i in range(len(parent1))])
    for i,j in enumerate(temp_child[:firstCrossPoint]):
        c=0
        for x in relations:
            if j == x[1]:
                child[i]=x[0]
                c=1
                break
        if c==0:
            child[i]=j
    j=0
    for i in range(firstCrossPoint,secondCrossPoint):
        child[i]=parent1MiddleCross[j]
        j+=1

    for i,j in enumerate(temp_child[secondCrossPoint:]):
        c=0
        for x in relations:
            if j == x[1]:
                child[i+secondCrossPoint]=x[0]
                c=1
                break
        if c==0:
            child[i+secondCrossPoint]=j
    child_unique=np.unique(child)
    if len(child)>len(child_unique):
        child=recursion2(child,firstCrossPoint,secondCrossPoint,parent1MiddleCross,parent2MiddleCross)
    return(child)

child1=recursion1(temp_child1,firstCrossPoint,secondCrossPoint,parent1MiddleCross,parent2MiddleCross)
child2=recursion2(temp_child2,firstCrossPoint,secondCrossPoint,parent1MiddleCross,parent2MiddleCross)

print(child1)
print(child2)

def inversion(tab):
    min=0
    max=len(tab)
    rand=random.randint(min,max)
    if rand!=max:
        pom=tab[rand]
        tab[rand]=tab[rand+1]
        tab[rand+1]=pom
    else:
        pom=tab[rand]
        tab[rand]=tab[0]
        tab[0]=pom
    print(f"Punkt inwersji: {rand}")
    print(f"Wynik inwersji: {tab}")

inversion(child1)
inversion(child2)
