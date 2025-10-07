Draw a line in a diagram from position (1,3) to (2,10) then to (6,12)     
and finally to position (18,20). (Mark each point with a red color and 
line style is dotted).

import matplotlib.pyplot as plt 
# Coordinates 
x = [1, 2, 6, 18] 
y = [3, 10, 12, 20] 
# Plotting dotted line with red points 
8.8        
plt.plot(x, y, 'r:o')  # red color, dot marker, dotted line 
plt.title("Dotted Line Between Points") 
plt.xlabel("X-axis") 
plt.ylabel("Y-axis") 
# Show plot 
plt.grid(True) 
plt.show() 

Write a program to create multiple plots. 

import matplotlib.pyplot as plt 
import numpy as np 
x = np.linspace(0, 10, 100) 
y1 = np.sin(x) 
y2 = np.cos(x) 
# Create 2 subplots in one row 
plt.subplot(1, 2, 1) 
plt.plot(x, y1, label='Sine') 
plt.title("Sine Wave") 
plt.subplot(1, 2, 2) 
plt.plot(x, y2, label='Cosine', color='orange') 
plt.title("Cosine Wave") 
plt.tight_layout() 
plt.show() 

 3.Write a python program to create bar plot of scores by group and gender.         
Use multiple x values on the same chart for men and women. Sample 
chart: 
Men : 22 30 35 35 26 
Women : 25 32 30 35 29 

import matplotlib.pyplot as plt 
import numpy as np 
# Data 
labels = ['G1', 'G2', 'G3', 'G4', 'G5'] 
men_scores = [22, 30, 35, 35, 26] 
women_scores = [25, 32, 30, 35, 29] 
x = np.arange(len(labels))  # the label locations 
width = 0.35  # width of the bars 
# Create bar plot 
plt.bar(x - width/2, men_scores, width, label='Men') 
plt.bar(x + width/2, women_scores, width, label='Women') 
# Labels and title 
plt.ylabel('Scores') 
plt.title('Scores by group and gender') 
plt.xticks(x, labels) 
plt.legend() 
plt.grid(True) 
plt.show() 

. Write a python program to plot two or more lines on same plot with 
suitable   legends of each line. 

import matplotlib.pyplot as plt 
x = [0, 1, 2, 3, 4, 5] 
y1 = [0, 1, 4, 9, 16, 25] 
y2 = [0, 1, 2, 3, 4, 5] 
# Plot multiple lines 
plt.plot(x, y1, label='Squared', color='blue', marker='o') 
plt.plot(x, y2, label='Linear', color='green', marker='s') 
# Add labels and legend 
plt.title("Multiple Lines on Same Plot") 
plt.xlabel("X-axis") 
plt.ylabel("Y-axis") 
plt.legend() 
plt.grid(True) 
plt.show()


Write a python program to display a pie chart, scatterplot, horizontal bar 
chart (using grid) of the popularity of programming language. 
Language: Java Python php  JavaScript   C#    C++ 


import matplotlib.pyplot as plt 
# Data 
languages = ['Java', 'Python', 'PHP', 'JavaScript', 'C#', 'C++'] 
popularity = [22.2, 17.6, 8.8, 8, 7.7, 6.7] 
# ------------------ Pie Chart ------------------ 
plt.figure(figsize=(10, 6)) 
plt.subplot(1, 3, 1) 
plt.pie(popularity, labels=languages, autopct='%1.1f%%', startangle=140) 
plt.title('Popularity - Pie Chart') 
# ------------------ Scatter Plot ------------------ 
plt.subplot(1, 3, 2) 
plt.scatter(languages, popularity, color='red', marker='o') 
plt.title('Popularity - Scatter Plot') 
plt.xticks(rotation=45) 
# ------------------ Horizontal Bar Chart ------------------ 
plt.subplot(1, 3, 3) 
plt.barh(languages, popularity, color='skyblue') 
plt.title('Popularity - Bar Chart') 
# plt.grid(True) 
plt.tight_layout() 
plt.show()
