def decipher(text, first_key, length, bound):
    res= ""
    key= first_key
    for i in range(length):
        c= text[i]
        if c >= 'a' and c <= 'z':
            c_ascii= ord(c) - 97
        else:
            c_ascii= ord(c) - 39

        c_ascii_deciphered= c_ascii ^ key
        if c_ascii_deciphered >= 0 and c_ascii_deciphered <= 25:
            c_char_deciphered= chr(c_ascii_deciphered + 97)
        else:
            c_char_deciphered= chr(c_ascii_deciphered + 39)

        res+= c_char_deciphered
        key= (key + 1) % bound
    return res

text= 'eaonj'
length= 5
bound= 32

for first_key in range(bound - 1):
    print(decipher(text, first_key, length, bound))
