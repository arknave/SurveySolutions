# Python 2
print "\n".join(["JARED" if reduce(lambda x, y: x ^ y, [len(set([int(raw_input().split()[0]) for i in range(int(raw_input()))])) for n in range(int(raw_input()))], 0) == 0 else "SCOTT" for t in range(int(raw_input()))])
