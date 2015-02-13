@echo off
title Acclea CMS import and export
setlocal
call av-env.cmd
java com.accela.adapter.service.impl.CapService
java com.accela.adapter.service.impl.InspectionService
popd
rem pause
endlocal