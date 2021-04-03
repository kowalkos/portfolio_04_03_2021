from random import randint
class Kość():
    def __init__(self,num_points=6):
        self.num_sides=num_points
    def roll(self):
        return randint(1,self.num_sides)
