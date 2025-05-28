plus :: [[String]] -> [String]
plus [] = []
plus x = [head li | li <- x, li !! 1 == "Simple", null (otros x (head li))]

otros :: [[String]] -> String -> [String]
otros x nom = [head a | a <- x, a !! 1 /= "Simple", head a == nom]




--plus [["Ana","Exclusivo","LSI"],["Mary","Semi","LCC"],["Jose","Simple","LSI"],["Mary","Simple","LSI"], ["Pepe","Simple","LSI"]]