require 'Deck.rb'



Shoes.app do
    
    
    @hand= Array.new(13)
    @handname= Array.new(13)
    @deck= Deck.new
    @deck.shuffle(200)
    
    @value=0
    
    @cardsinhand=0
    
    @dealerstatus
    @dealervalue
    
    @wins=0
    @losses=0
    
    @numwins
    @numlosses
    @lost1=0
    
    
    flow{
        
        
        stack :width => '33%' do
                        
            
            @valuenote= para "Value in your hand is 0"
            drawbutton= button "Draw Card"
            shufflebutton= button "Shuffle Deck"
            resetbutton= button "Reset"
            
            #x1=para ""+1.to_s
            
            
            @index=0
            
            
            i=0
            
            para "Your Hand is as Follows:"
            
            while (i<13) do
                
                @handname[i] = para ""
                i+=1
                
            end
                
                shufflebutton.click{
                    
                    @deck.shuffle(100)
                }
                
                
                
                drawbutton.click{
                    
                    if (@index<13 && (@lost1==0))
                        x= @deck.drawCard()
                        @value+=x.getValue()
                        @cardsinhand+=1
                        
                        @hand[@index]=x
                        @handname[@index].replace x.getCardName()
                        
                        @index+=1
                        
                        @valuenote.replace "Value in your hand is "+@value.to_s+" now."
                        
                        #x1.replace ""+@lost1.to_s
                        
                        if (@value>21) then
                            
                           
                            @lost1=1
                            @handname[@index].replace "YOU LOST!!"
                            @losses+=1
                            @numlosses.replace "            Losses: "+@losses.to_s
                             
                            
                            #x1.replace ""+lost1.to_s
                        end
                    end
                    
                }
                
                
                
                
                
                
                
                resetbutton.click{
                    
                    
                    
                        reset()
                            
                            
                    }
                            
                           
                        
            end
                       
                        
                    def reset()
                        
                    i=0
                    for i in @handname do
                
                
                            i.replace ""
                
                
                    end
                
                        i=0
                
                        until (i==(@cardsinhand-1)) do
                    
                            @deck.placeCard(@hand[i])
                            @deck.shuffle(100)
                            i+=1
                    
                        end
                    
                    
                    
                            @valuenote.replace "Value in your hand is 0"
                            @dealerstatus.replace "Dealer's Value is 0"
                            @index=0
                            @cardsinhand=0
                            @value=0
                            @lost1=0
                        
                    end
                            
                       
                        
                        
                        flow :width => '33%'do
                            
                            para "          "
                            staybutton=button "Stay"
                            staybutton.click{
                                
                                
                                @dealervalue=rand(7)+16
                                
                                @dealerstatus.replace "Dealer's Value is "+@dealervalue.to_s
                                
                                if ((@dealervalue>@value && @value<=21)) then
                                   
                                    @handname[@index].replace "YOU LOST!!"
                                    @losses+=1
                                    @numlosses.replace "            Losses: "+@losses.to_s
                                    
                                end
                                
                                if ((@dealervalue<@value && @value<=21) || (@dealervalue>21 and @value<=21)) then
                                    
                                    @handname[@index].replace "YOU WIN!!"
                                    @wins+=1
                                    @numwins.replace "            Wins: "+@wins.to_s
                                    
                                end
                                
                                if (@dealervalue==@value && @value<=21) then
                                    
                                    @handname[@index].replace "TIE!!"
                                    
                                end
                                
                                @lost1=1
                                #reset()
                                
                            }
                            
                            stack do
                                
                            @numwins=para "            Wins: 0"
                            @numlosses=para "            Losses: 0"
                                
                            end
                                
                                
                            end
                        
                        
                        
              
                            stack :width => '33%'do
                                
                                para "Dealer"
                                @dealerstatus= para ""
                                
                            end
      
     
                            
                            
                            
        }
                            
                            
                            
            
            
            
            
            
            

end