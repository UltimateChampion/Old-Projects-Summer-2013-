class Card
    
    def initialize(s, r, x)

        @suit=s
        @rank=r
        @value=x
    end
    
    
    def printCard()
        
        puts @rank.to_s+" of "+@suit.to_s
    
    end
    
    def getValue()
       
        return @value
        
    end
    
    def getCardName()
        
        return @rank.to_s+" of "+@suit.to_s
    end


end