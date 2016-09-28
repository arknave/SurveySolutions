T = int(raw_input())

for t in range(T):
    N, M = map(int, raw_input().split())
    intervals = [map(int, raw_input().split()) for i in range(N)]
    queries = [(float(raw_input()), i) for i in range(M)]
    pluses = map(lambda x: x[0], intervals)
    minuses = map(lambda x: x[1], intervals)
    pluses.sort()
    minuses.sort()
    queries.sort()
    answers = [-1]*M
    cur = 0
    nextplus = 0
    nextminus = 0
    for query, i in queries:
        while nextplus < N and pluses[nextplus] <= query:
            nextplus += 1
            cur += 1
        while nextminus < N and minuses[nextminus] < query + 1e-6:
            nextminus += 1
            cur -= 1
        answers[i] = cur
    print "\n".join(map(str, answers))
