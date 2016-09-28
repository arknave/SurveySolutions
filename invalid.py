# Python 2
T = int(raw_input())

for t in range(T):
    N = int(raw_input())
    count = 0
    for n in range(N):
        H, W = map(int, raw_input().split())
        if H < 6 or H > 21 or W < 0 or W > 1024:
            count += 1
    print count
