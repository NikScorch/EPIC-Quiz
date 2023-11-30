with open("data/questions.csv", "r") as fp:
    fp.readline()
    data = fp.read().split(",")

    for i in range(18):
        print(data[0 + (i * 8)])
        print(end="\t")
        print(data[1 + (i * 8)])
        print(end="\t")
        print(data[2 + (i * 8)])
        print(end="\t")
        print(data[3 + (i * 8)])
        print(end="\t")
        print(data[4 + (i * 8)])
        