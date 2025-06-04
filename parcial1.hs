inserta :: (Integral a, Ord a) => [a] -> [a] -> [a]
inserta [] b = b
inserta (x:a) b = inserta a (insertaUno x b)

insertaUno :: (Integral a, Ord a) => a -> [a] -> [a]
insertaUno x [] = [x]
insertaUno x (y:ys)
  | x == y    = y:ys
  | x < y     = x:y:ys
  | otherwise = y : insertaUno x ys