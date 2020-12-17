import hmac
import hashlib
import re

# secret key
key = 'openthesasame'

# keyed hash function (DON'T MODIFY)
def hash(k, m):
    return hmac.new(k.encode('utf-8'), m.encode('utf-8'), hashlib.md5).hexdigest()

# sign the message (DON'T MODIFY)
def sign_message(k, msg):
    return msg + ":" + hash(k, msg)

# check if the message is tampered by someone who does not have the key
#   - return True if the message is not tampered
#   - return False otherwise
def verify_message(k, signed_msg):
    splitted= signed_msg.split(':')
    if len(splitted) >= 2:
        recv_mac= splitted[1]
        calc_mac= hash(k, splitted[0])
        return calc_mac == recv_mac
    else:
        return False
    

# main program
if __name__ == '__main__':
    message = 'My credit card number is 0123-4567-8901-2345.'
    print('Original message:', message)
    print()

    signed_message = sign_message(key, message)
    print('Message with signature:', signed_message)

    is_valid = verify_message(key, signed_message)
    print('--> Is this message valid?:', is_valid)
    print()

    tampered_message = signed_message[:26] + "7" + signed_message[27:]
    print('Tampered message with signature:', tampered_message)

    is_valid = verify_message(key, tampered_message)
    print('--> Is this message valid?:', is_valid)
    print()
