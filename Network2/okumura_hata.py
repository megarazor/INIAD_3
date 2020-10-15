import math

def a(city_size, hm, f):
    if city_size == 0:
        return (1.1 * math.log10(f) - 0.7) * hm - (1.56 * math.log10(f) - 0.8)
    elif f <= 400:
        return 8.29 * (math.log10(1.54 * hm)) ** 2 - 1.1
    else:
        return 3.2 * (math.log10(11.75 * hm)) ** 2 - 4.97

def loss_okuhata(hb, f, hm, d, city_size):
    loss = 69.55 + 26.16 * math.log10(f) - 13.82 * math.log10(hb) + (44.90 - 6.55 * math.log10(hb)) * math.log10(d) - a(city_size, hm, f)
    return loss

def increased_loss(hb, d_inceased_times):
    return (44.9 - 6.55 * math.log10(hb)) * math.log10(d_inceased_times)

hb= 190 # [m]
f= 800 # [MHz]
hm= 1.5 # [m]
d= 1 # [km]
city_size= 0 # 0 for small-medium, 1 for big

loss= loss_okuhata(hb, f, hm, d, city_size)
print("Loss [dB] =", loss_okuhata(hb, f, hm, 10, city_size) - loss_okuhata(hb, f, hm, 1, city_size) )

d_inceased_times= 10
hb= 100
delta_loss= increased_loss(hb, d_inceased_times)
print("Lossed increased by", delta_loss, "[dB]")
