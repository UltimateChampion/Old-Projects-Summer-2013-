require 'Card.rb'


class Deck
    
    def initialize()
        
        @ftdeck=Array.new(52)
        @cardsindeck=52
        @initialsize=@cardsindeck
        
        j=1
        st="Clubs"
        i=0
        
        while (i<52) do
            
            if (i==13) then
                st="Diamonds"
            end
            
            if (i==26) then
                st="Hearts"
                
            end
            
            if (i==39) then
                st="Spades"
            end
            
            
            j=(i%13)+1
            x=j
            
            if (j==1) then
                
                j=j.to_s
                j=j.gsub("1", "Ace")
                
            end 
            
            j=j.to_s
            
            j=j.gsub("13", "King")
            j=j.gsub("12", "Queen")
            j=j.gsub("11", "Jack")
            
            
            if (x>10) then
               x=10
            end
            
            @ftdeck[i]=Card.new(st, j, x)
            
            
            #@ftdeck[i].printCard()
            
            i=i+1
            
        end
    end

        
        
    def shuffle(num)
            
        i=0
            
        while i<num do
                switch(rand(@cardsindeck),rand(@cardsindeck) )
                i+=1
        end
                
    end
            
            
    def switch(a, b)
                
        temp=@ftdeck[a]
        @ftdeck[a]=@ftdeck[b]
        @ftdeck[b]=temp
                
                
    end
         
        
        
            
    def printDeck()
                
        i=0
        while i<@cardsindeck
                    
            @ftdeck[i].printCard()
            i=i+1
            
                    
        end
                    
                    
    end
              
        
    def drawCard()
        
        puts @cardsindeck.to_i
        @cardsindeck-=1
        
        x=Card.new("","",0)
        
        x=@ftdeck[(@cardsindeck.to_i)]
        return x
 
    
    end
        
        
        
    def placeCard(cd)
       
        if (@cardsindeck>=@initialsize) then
            puts "Deck is full. You may not add another card."

        else
            
            @cardsindeck+=1
            @ftdeck[@cardsindeck]=cd
        end 
        
    end
                
                
                
end
            

