import string, secrets

if __name__ == '__main__':
    letter = secrets.choice(string.ascii_letters)
    print(letter)