import csv

def words(readfile):
    for line in readfile:
        for word in line.split():
            yield word

if __name__ == '__main__':
        with open("PracticeInput.txt", "r") as myfile:
                wordgen = words(myfile)
                ipAddress = []
                for word in myfile:
                        if word != "":
                                break
                        else:
                                word = None
                foundwords = [word, next(wordgen, None), next(wordgen, None)]
                print(foundwords)
