def solve(time, endpoints):
    low = 0
    high = len(endpoints) - 1
    max_valid_time = -1
    max_index = -1
    if time > endpoints[len(endpoints) - 1][0]:
        return 0
    elif time < endpoints[0][0]:
        return 0
    while low <= high:
        mid = low + (high - low) // 2
        if endpoints[mid][0] == time:
            return endpoints[mid][1]
        elif endpoints[mid][0] < time:
            if endpoints[mid][0] > max_valid_time:
                max_valid_time = endpoints[mid][0]
                max_index = mid
            low = mid + 1
        else:
            high = mid - 1
    if max_valid_time == -1:
        return 0
    return endpoints[max_index][1]

def preprocess(endpoints):
    counts = {}
    count = 0
    end_value = -1
    subtract = False
    num_subtract = 0
    for i in range(0, len(endpoints)):
        if endpoints[i][1] == 0:
            count += 1
        else:
            count -= 1
        counts[endpoints[i][0]] = count
    counts_list = [(k,v) for k,v in counts.items()]
    counts_list.sort()
    return counts_list


def main():
    t = int(input())
    for i in range(t):
        endpoints = []
        ta, queries = map(int, input().split())
        for j in range(ta):
            start, end = map(int, input().split())
            endpoints.append((start, 0))
            endpoints.append((end, 1))
        endpoints.sort()
        counts = preprocess(endpoints)
        for j in range(queries):
            print(solve(float(input()), counts))


if __name__ == '__main__':
    main()
