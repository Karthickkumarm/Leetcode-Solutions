# https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/

class Solution(object):
    def removeSubfolders(self, folder):
        f=set(folder)
        ans=[]
        for n in folder:
            ans.append(n)
            for i in range(len(n)):
                if n[i]=='/' and n[:i] in f:
                    ans.pop()
                    break 
        return ans
        