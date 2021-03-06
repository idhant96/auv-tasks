import cv2
import numpy as np

#Some Defs
img=cv2.imread('buoysf.jpg')
hsv=cv2.cvtColor(img,cv2.COLOR_BGR2HSV)

screen_res = 1366, 768
scale_width = screen_res[0] / img.shape[1]
scale_height = screen_res[1] / img.shape[0]
scale = min(scale_width, scale_height)
window_width = int(img.shape[1] * scale)
window_height = int(img.shape[0] * scale)

cv2.namedWindow('control', cv2.WINDOW_NORMAL)
cv2.resizeWindow('control', window_width, window_height)

kernel = np.ones((5,5),np.uint8)
result = hsv

def cont(clr,im):

   #ret, thresh = cv2.threshold(im, 127, 255,0)
   #cv2.imshow('original bin', thresh)
   contours,_ = cv2.findContours(im, 1, 2)

   cnt = contours[0]

   M = cv2.moments(cnt)
   cx = int(M['m10'] / M['m00'])
   cy = int(M['m01'] / M['m00'])
   cv2.circle(img, (cx, cy), 1, (255, 255, 255), -1)
   cv2.putText(img, clr, (cx - 20, cy - 20),
               cv2.FONT_HERSHEY_SIMPLEX, 0.5, (255, 255, 255), 2)
   cv2.imshow('control',img)


def nothing(x):
   pass

switchG = '0 : green \n1 : set'
cv2.createTrackbar(switchG, 'control',0,1,nothing)

switchR = '0 : Red \n1 : Set '
cv2.createTrackbar(switchR, 'control',0,1,nothing)

switchY = '0 : Yellow   \n1 : Set '
cv2.createTrackbar(switchY, 'control',0,1,nothing)

#hardcoding the hsv color spaces for ease
low_yellow=np.array([22,118,200])
high_yellow=np.array([38,255,255])
low_red=np.array([0,140,177])
high_red=np.array([21,255,255])
low_green=np.array([69,160,101])
high_green=np.array([82,255,255])

while True:

    k = cv2.waitKey(30) & 0xFF
    if k == 27 :
        cv2.destroyAllWindows()
        break

    sR = cv2.getTrackbarPos(switchR, 'control')
    sG = cv2.getTrackbarPos(switchG, 'control')
    sY = cv2.getTrackbarPos(switchY, 'control')
    if sR == 1:
        mask = cv2.inRange(hsv, low_red, high_red)
        cv2.morphologyEx(img, cv2.MORPH_OPEN, kernel, mask)
        result = cv2.bitwise_and(hsv, hsv, mask=mask)
        _, _, v = cv2.split(result)
        cont("ORANGE", v)

    if sG == 1:
        mask = cv2.inRange(hsv, low_green, high_green)
        cv2.morphologyEx(img, cv2.MORPH_OPEN, kernel, mask)
        result = cv2.bitwise_and(hsv, hsv, mask=mask)
        _, _, v = cv2.split(result)
        cont("green", v)
    if sY == 1:
       mask = cv2.inRange(hsv, low_yellow, high_yellow )
       cv2.morphologyEx(img, cv2.MORPH_OPEN, kernel, mask)
       result = cv2.bitwise_and(hsv, hsv, mask=mask)
       _,_,v=cv2.split(result)
       cont("YEllOW",v)




cv2.destroyAllWindows()
