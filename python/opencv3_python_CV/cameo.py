import cv2
from managers import *
class Cameo(object):
    def __init__(self):
        self._windowManager = WindowManager('Cameo', self.onKeypress)
        self._captureManager = CaptureManager(cv2.VideoCapture(0), self._windowManager, True)
    def run(self):
        self._windowManager.createWindow()
        while self._windowManager.isWindowCreated:
            self._captureManager.enterFrame()
            frame = self._captureManager.enterFrame
            self._captureManager.exitFrame()
            self._windowManager.processEvents()
    def onKeypress(self,keycode):
        if keycode == 32:  # space
            self._captureManager.writeImage('screenshot.png')
        elif keycode == 9:  # tab
            if not self._captureManager.isWritingVideo:
                self._captureManager.startWritingVideo('screenshot.avi')
            else:
                self._captureManager.stopWritingVideo()
        elif keycode == 27:    # escape
            self._windowManager.destoryWindow()
if __name__ == "__main__":
    Cameo().run()
#按空格键可获取截图信息，按tab键可启动/停止截屏（一个视频记录），按Esc键可退出应用程序。