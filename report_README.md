# Final-Project

組員: B08902011杜展廷、B08902025王熙創
- 因為wsl X11問題我們使用powershell進行開發，makefile command沒有環境能夠測試，如果遇到問題請使用Start.bat啟動遊戲。
- 以下為開發時資訊，並非最終定案
- Description:
    - src/
        - BasicObject/
            - Button (has a JButton)，用來對接JButton。
            - Picture
        - GameScene/
            - ScreenController
            - Screen
            - Game
            - Shop
            - Menu
        - Player/
            - Opponent，RuleBase AI?
            - Player，紀錄玩家本身的資訊
            - Item，玩家可以持有的道具
        - Servant/
            - Servant，被召喚的Father Class。
            - Tower，要被打爆的東西
            - Unit，上述兩者的Father，自帶血條。

