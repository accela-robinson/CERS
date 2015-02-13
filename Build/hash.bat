@echo off
setlocal
call av-env.cmd
java com.accela.cers.HashService
pause
endlocal