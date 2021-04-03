import math
def liczba_bitów(a,b,d):
    wartość=(b-a)*10^d
    c= math.log2(wartość)
    return round(c)
print(liczba_bitów(-2,2,5))