def kody_pocztowe_zad1(s1,s2):
    x=int(s1.split('-')[0])
    x1=int(s1.split('-')[1])
    y=int(s2.split('-')[0])
    y1=int(s2.split('-')[1])
    tabzw=[]
    while x<=y:
        if x==y:
            while x1<=y1:
                tabzw.append('{}-{}'.format(x,x1))
                x1+=1
        else:
            while x1<1000:
                tabzw.append('{}-{}'.format(x,x1))
                x1+=1
        x+=1
        x1=0
    print(tabzw)
    return tabzw
def sprawdzanie_listy_zad2(lista,n):

    tabzw=[]
    j=0
    for i in range(1,n+1):
        if j<len(lista) and i==lista[j] :
            j+=1
        else:
            tabzw.append(i)
    print(tabzw)
    return tabzw
def generowanie_listy_zad3():
    print([i/10 for i in range(20,55+1,5)])
    return [i/10 for i in range(20,55+1,5)]

