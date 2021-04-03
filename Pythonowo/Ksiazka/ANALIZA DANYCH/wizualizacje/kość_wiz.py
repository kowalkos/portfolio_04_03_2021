from kość import Kość
from plotly.graph_objs import Bar,Layout
from plotly import offline
kość1=Kość()
kość2=Kość(10)
wyniki=[]
for roll_num in range(10000):
    result=kość1.roll()+kość2.roll()
    wyniki.append(result)
częstotliwości=[]
maxres=kość1.num_sides+kość2.num_sides
for wartość in range(2,maxres+1):
    częstotliwość=wyniki.count(wartość)
    częstotliwości.append(częstotliwość)
x_values=list(range(2,maxres+1))
data=[Bar(x=x_values,y=częstotliwości)]
x_axis_config={'title':'Wynik','dtick':1}
y_axis_config={'title':'Częstotliwość występowania wartości'}
my_layout=Layout(title='Wynik rzucania kością X razy',
xaxis=x_axis_config,yaxis=y_axis_config)
offline.plot({'data':data,'layout':my_layout},filename='d6.html')