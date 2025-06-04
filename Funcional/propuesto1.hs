listaTotal :: [[a]] -> [a]
listaTotal [] = []
listaTotal x = [e | li <- x , e <- li]