location = input()
column = ord(location[0])-96
row = int(location[1])
count = 0

print(column, row)
print()

move = [[1,2],[1,-2],[-1,2],[-1,-2],[2,1],[2,-1],[-2,1],[-2,-1]] ## 움직일 수 있는 범위

nColumn = column
nRow = row
for i in range(len(move)):
    nColumn = column + move[i][0]
    if nColumn > 8 or nColumn <= 0:
        continue
    nRow = row + move[i][1]
    if nRow > 8 or nRow <= 0:
        continue
    count += 1
    print(nColumn,nRow)
    print()

print(count)

