'''
@Author 최제현
@Date 21/1/8

'''


class PropertyChange:
    # 단위액
    plusNum = ",000"

    # 이름 바꿔야함 나중에.

    def __init__(self):
        self.previousValue = None
        self.presentValue = None
        self.totalIncrease = None
        self.totalDecrease = None
        self.fileEndPosition = None

    @property
    def getPropertyDetail(self):
        return self.propertyDetail

    @getPropertyDetail.setter
    def setPropertyDetail(self, detail):
        self.propertyDetail = detail


    @property
    def getPreviousValue(self):
        if self.previousValue != None:
            return self.previousValue
        else:
            return None

    @getPreviousValue.setter
    def setPreviousValue(self, preValue):
        if preValue != '0':
            # self.__previousValue = (preValue + self.plusNum).replace(",","")
            self.previousValue = preValue + self.plusNum
        elif preValue == '0':
            self.previousValue = preValue
        else:
            print(self.fileStartPosition + "error")

    @property
    def getPresentValue(self):
        if self.presentValue != None:
            return self.presentValue
        else:
            return None

    @getPresentValue.setter
    def setPresentValue(self, nowValue):
        if nowValue != '0':
            # self.__presentValue = (nowValue + self.plusNum).replace(",","")
            self.presentValue = nowValue + self.plusNum
        elif nowValue == '0':
            self.presentValue= nowValue
        else:
            print(self.fileStartPosition + "error")

    @property
    def getTotalIncrease(self):
        if self.totalIncrease != None:
            return self.totalIncrease
        else:
            return None

    @getTotalIncrease.setter
    def setTotalIncrease(self, increase):
        if increase != '0':
            # self.__totalIncrease = (increase + self.plusNum).replace(",","")
            self.totalIncrease = increase + self.plusNum
        elif increase == '0':
            self.totalIncrease = increase
        else:
            print(self.fileStartPosition + "error")

    @property
    def getTotalDecresase(self):
        if self.totalDecrease != None:
            return self.totalDecrease
        else:
            return None

    @getTotalDecresase.setter
    def setTotalDecrease(self,decrease):
        if decrease != '0':
            # self.__totalDecrease = (decrease + self.plusNum).replace(",","")
            self.totalDecrease = decrease + self.plusNum
        elif decrease == '0':
            self.totalDecrease = decrease
        else:
            print(self.fileStartPosition + "error")

    @property
    def getReason(self):
        if self.reason != None:
            return self.reason
        else:
            return None

    @getReason.setter
    def setReason(self, reason):
        self.reason = reason

    @property
    def getFileStartPosition(self):
        return self.fileStartPosition

    @getFileStartPosition.setter
    def setFileStartPosition(self, pos):
        self.fileStartPosition = pos

    @property
    def getFileEndPosition(self):
        return self.fileEndPosition

    @getFileEndPosition.setter
    def setFileEndPosition(self, pos):
        self.fileEndPosition = pos

    @property
    def getCategory(self):
        return self.category
    @getCategory.setter
    def setCategory(self, section):
        self.category = section

    @property
    def getDeepCategory(self):
        return self.deepCategory
    @getDeepCategory.setter
    def setDeepCategory(self, section):
        self.deepCategory = section


    @property
    def getWhos(self):
        return self.whos
    @getWhos.setter
    def setWhos(self, who):
        self.whos = who


    # def getFileStartPos(self):
    #     return self.fileStartPos
    #
    # def getFileEndPos(self):
    #     return self.fileEndPos
