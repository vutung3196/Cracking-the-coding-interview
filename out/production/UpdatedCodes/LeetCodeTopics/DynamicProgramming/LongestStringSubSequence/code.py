
def lcs(A, B):
    a, b = len(A), len(B)
    x = [[0] * (2) for _ in range(3 + 1)]
    for i in reserved