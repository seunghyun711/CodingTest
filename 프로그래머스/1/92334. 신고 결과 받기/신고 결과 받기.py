# 1. 개인별 신고한 횟수와 개인별 신고당한 횟수를 담을 배열 선언
# 2. report 배열을 통해 신고 결과를 reportList 배열에 저장
# 3. 개인별 신고를 받은 총 횟수 계산
# 4. 총 신고 횟수 >= k 이면 해당 유저를 신고한 유저들의 신고 메일 수 증가
def solution(id_list, report, k):
    users = len(id_list) # 유저수
    # print("users : ", users)
    # 1. 개인별 신고한 횟수와 개인별 신고당한 횟수를 담을 배열 선언
    # 행의 마지막 인덱스에는 개인별 신고당한 횟수를 저장
    reportList = [[0 for i in range(users + 1)] for _ in range(users)]
    
    resultMails = [0 for i in range(users)] # 개인별 받게될 결과 메일의 수를 저장

    # 2. report 배열을 통해 신고 결과를 reportList 배열에 저장
    for name in report:
        reporter, respondent = name.split() # 신고자(reporter)와 신고당한 사람 저장(respondent)
        # 이미 유저가 신고할 유저를 이전에 신고한 경우 신고 횟수는 1로 처리
        if(reportList[id_list.index(reporter)][id_list.index(respondent)] != 1):       
            reportList[id_list.index(reporter)][id_list.index(respondent)] += 1
    # print("reportList = ", reportList)
    # 3. 개인별 신고를 받은 총 횟수 계산
    calcReport(reportList, users)

    # 4. '총 신고 횟수 >= k' 이면 해당 유저를 신고한 유저들의 신고 메일 수 증가
    for i in range(users):
        if(reportList[i][users] >= k):
            calcSendMails(reportList, i, resultMails, users)

    return resultMails

# 신고 받은 총 횟수를 계산하는 메서드
def calcReport(reportList, users):
    for i in range(users):
        for j in range(users):
            if(reportList[i][j] == 1):
                reportList[j][users] += 1

# 유저가 받게 될 메일의 수를 계산하는 메서드
def calcSendMails(reportList, i, resultMails, users):
    for user in range(users):
        if(reportList[user][i] == 1):
            resultMails[user] += 1