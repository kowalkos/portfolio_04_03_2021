import csv
import matplotlib.pyplot as plt
from datetime import datetime
filename='sitka_weather_2018_simple.csv'
dates,highs,lows=[],[],[]
with open(filename) as f:
    reader=csv.reader(f)
    
    header=next(reader)
    
    for row in reader:
        current_date=datetime.strptime(row[2],"%Y-%m-%d")
        high=int(row[5])
        low=int(row[6])
        lows.append(low)
        dates.append(current_date)
        highs.append(high)
    print(highs)        
plt.style.use('seaborn')
fig,ax=plt.subplots()
ax.plot(dates,highs,c='red',alpha=0.5)
ax.plot(dates,lows,c='blue',alpha=0.5)
ax.fill_between(dates,highs,lows,facecolor='blue',alpha=0.1)
ax.set_title("Najwyższa temperatura dnia",fontsize=24)
ax.set_xlabel('')
fig.autofmt_xdate()
ax.set_ylabel("tempereatura (F)",fontsize=16)
ax.tick_params(axis='both',which='major',labelsize=16)
plt.show()