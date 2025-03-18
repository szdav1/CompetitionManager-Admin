@echo off
set from_jar=%1
set to_jar=%2
set from_res=%3
set to_res=%4

xcopy %from_jar% %to_jar% /f /e /y
xcopy %from_res% %to_res% /f /e /y