from random import choice
def convert(list): 
      
    # Converting integer list to string list 
    # and joining the list using join() 
    res = int("".join(map(str, list))) 
      
    return res 
tab=[]
for i in range(16):
    tab.append(choice([0,1]))
print(tab)
x1=convert(tab[0:8:-1])
x2=convert(tab[8:16])
decimal=(x1+2)/((2+2)/(2^8-1))
print(decimal)