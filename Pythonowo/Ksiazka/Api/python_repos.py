import requests
from plotly.graph_objs import Bar
from plotly import offline
url='https://api.github.com/search/repositories?q=language:python&sort:stars'
headers={'Accept':'application/vnd.github.v3+json'}
r=requests.get(url,headers=headers)
print(f"Kod stanu: {r.status_code}")
response_dict=r.json()
print(f"całkowita liczba repozytoriów{response_dict['total_count']}")
repo_dicts=response_dict['items']
repo_links,stars,labels=[],[],[]
for repo_dict in repo_dicts:
    repo_name=repo_dict['name']
    repo_url=repo_dict['html_url']
    repo_link=f"<a href='{repo_url}'>{repo_name}</a>"
    repo_links.append(repo_link)
    stars.append(repo_dict['stargazers_count'])
    owner=repo_dict['owner']['login']
    description=repo_dict['description']
    label=f"{owner}<br />{description}"
    labels.append(label)
data=[{'type':'bar','x':repo_links,'y':stars,'hovertext':labels}]
my_layout={'title':'Oznaczone największą liczbą gwiazdek projekty Pythona',
    'xaxis':{'title':'Repozytorium'},
    'yaxis':{'title':'Gwiazdki'},}
fig={'data':data,'layout':my_layout}
offline.plot(fig,filename='python_repos.html')








"""
print(f"liczba zwróconych repozytoriów{len(repo_dicts)}")
repo_dict=repo_dicts[0]
print(f"\nKlucze: {len(repo_dict)}")
for key in sorted(repo_dict.keys()):
    print(key)
    
print("\nWybrane informacje o pierwszym repozytorium")
print(f"Nazwa: {repo_dict['name']}")
print(f"Właściciel: {repo_dict['owner']['login']}")
print(f"Gwiazdki: {repo_dict['stargazers_count']}")
print(f"Opis: {repo_dict['description']}")"""
