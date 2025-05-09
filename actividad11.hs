sumaComplejos :: (Integral a) => [[a]] -> [a]
sumaComplejos l = [sum (map head l), sum (map last l)]