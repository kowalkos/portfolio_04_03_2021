import json
from plotly.graph_objs import Scattergeo, Layout
from plotly import offline
filename='eq_data_30_day_m1.json'
with open(filename) as f:
    all_eq_data=json.load(f)
all_eq_dicts=all_eq_data['features']
mags,lons,lats,hover_text=[],[],[],[]
for eq_dict in all_eq_dicts:
    mag=eq_dict['properties']['mag']
    lon=eq_dict['geometry']['coordinates'][0]
    lat=eq_dict['geometry']['coordinates'][1]
    title=eq_dict['properties']['title']
    hover_text.append(title)
    lons.append(lon)
    lats.append(lat)
    mags.append(mag)
data=[{
    'type':'scattergeo',
    'lon':lons,
    'lat':lats,
    'text':hover_text,
    'marker':{
        'size':[5*mag for mag in mags],
        'color':mags,
        'colorscale':'Viridis',
        'reversescale':True,
        'colorbar':{'title':'Siła'},

    }
,}]
my_layout=Layout(title='trzęsienia ziemi')
fig={'data':data,'layout':my_layout}
offline.plot(fig,filename='global_earthquake.html')