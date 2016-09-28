# Python 2
def readPlot():
    P = int(raw_input())
    points = []
    for p in range(P):
        x, y = map(int, raw_input().split())
        points.append((x, y))
    return points

T = int(raw_input())

for t in range(T):
    N = int(raw_input())
    xor = 0
    for n in range(N):
        points = readPlot()
        xCoords = map(lambda x: x[0], points)
        numDistinctX = len(set(xCoords))
        xor ^= numDistinctX
    if xor == 0:
        print "JARED"
    else:
        print "SCOTT"
