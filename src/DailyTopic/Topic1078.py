# -*- coding: utf-8 -*-
# =========================================================
# @Author:
#                             _                  _        _ 
#                            (_)                | |      (_)
# __  __ _   _   ___   __  __ _   __ _   ___    | |  ___  _ 
# \ \/ /| | | | / _ \  \ \/ /| | / _` | / _ \   | | / _ \| |
#  >  < | |_| ||  __/   >  < | || (_| || (_) |  | ||  __/| |
# /_/\_\ \__,_| \___|  /_/\_\|_| \__,_| \___/   |_| \___||_|
# @Time: 2021/12/27 22:18
# =========================================================
class Solution:
    def findOcurrences(self, text: str, first: str, second: str) -> List[str]:
        res = []
        txt = text.split(' ')
        for i in range(len(txt)-2):
            if txt[i] == first and txt[i+1] == second:
                res.append(txt[i+2])
        return res