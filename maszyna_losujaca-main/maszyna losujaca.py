from random import randint
import PySimpleGUI as sg


layout=[[sg.Text('Wylosowana liczba:')],
        [sg.Text('  ',key='tekst',font=20,size=(50,1))],
        [sg.Button('losowansko'),sg.CloseButton('zamknij')]]
window = sg.Window('Window Title', layout,size=(400,200))   

while True:
    event, values = window.read()    
    if event is None or event=='zamknij':
        break
    if event == 'losowansko':
        f=open('liczby.txt','r+')
        str=f.read()
        f.close()
        tab=str.split(',')
        liczba_wylosowana=tab[randint(0,len(tab)-1)]
        tab.remove(liczba_wylosowana)
        noweliczby=''
        
        f=open('liczby.txt','w')
        if len(tab)==0:
            window['tekst'].update('WSZYSTKO WYLOSOWANO')
        else:
            noweliczby+='{}'.format(tab[0])
            for i in tab[1:]:
              noweliczby+=',{}'.format(i)
            f.write(noweliczby)
            f.close()
            window['tekst'].update(liczba_wylosowana)
    
window.close()




