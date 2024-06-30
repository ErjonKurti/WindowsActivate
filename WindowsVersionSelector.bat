REM Copyright (c) Erjon Kurti

@echo off
cls
echo Windows Version Selector
echo -----------------------

REM Define Windows versions and their associated commands
set "Home_Core=cscript slmgr.vbs /ipk TX9XD-98N7V-6WMQ6-BX7FG-H8Q99"
set "Home_Core_Country_Specific=cscript slmgr.vbs /ipk PVMJN-6DFY6-9CCP6-7BKTT-D3WVR"
set "Home_Core_Single_Language=cscript slmgr.vbs /ipk 7HNRX-D7KGG-3K4RQ-4WPJ4-YTDFH"
set "Home_Core_N=cscript slmgr.vbs /ipk 3KHY7-WNT83-DGQKR-F7HPR-844BM"
set "Professional=cscript slmgr.vbs /ipk W269N-WFGWX-YVC9B-4J6C9-T83GX"
set "Professional_N=cscript slmgr.vbs /ipk MH37W-N47XK-V7XM9-C7227-GCQG9"
set "Enterprise=cscript slmgr.vbs /ipk NPPR9-FWDCX-D2C8J-H872K-2YT43"
set "Enterprise_N=cscript slmgr.vbs /ipk DPH2V-TTNVB-4X9Q3-TJR4H-KHJW4"
set "Education=cscript slmgr.vbs /ipk NW6C2-QMPVW-D7KKK-3GKT6-VCFB2"
set "Education_N=cscript slmgr.vbs /ipk 2WH4N-8QGBV-H22JP-CT43Q-MDWWJ"
set "Enterprise_2015_LTSB=cscript slmgr.vbs /ipk WNMTR-4C88C-JK8YV-HQ7T2-76DF9"
set "Enterprise_2015_LTSB_N=cscript slmgr.vbs /ipk 2F77B-TNFGY-69QQF-B8YKP-D69TJ"
set "Enterprise_2016_LTSB=cscript slmgr.vbs /ipk DCPHK-NFMTC-H88MJ-PFHPY-QJ4BJ"
set "Enterprise_2016_LTSB_N=cscript slmgr.vbs /ipk QFFDN-GRT3P-VKWWX-X7T3R-8B639"

REM Define function to prompt user and execute command
:promptAndRun
echo Select a Windows version:
echo 1. Home/Core
echo 2. Home/Core (Country Specific)
echo 3. Home/Core (Single Language)
echo 4. Home/Core N
echo 5. Professional
echo 6. Professional N
echo 7. Enterprise
echo 8. Enterprise N
echo 9. Education
echo 10. Education N
echo 11. Enterprise 2015 LTSB
echo 12. Enterprise 2015 LTSB N
echo 13. Enterprise 2016 LTSB
echo 14. Enterprise 2016 LTSB N

set /p choice="Enter the number of your selection: "

REM Execute command based on user input
if "%choice%"=="1" (
    %Home_Core%
) else if "%choice%"=="2" (
    %Home_Core_Country_Specific%
) else if "%choice%"=="3" (
    %Home_Core_Single_Language%
) else if "%choice%"=="4" (
    %Home_Core_N%
) else if "%choice%"=="5" (
    %Professional%
) else if "%choice%"=="6" (
    %Professional_N%
) else if "%choice%"=="7" (
    %Enterprise%
) else if "%choice%"=="8" (
    %Enterprise_N%
) else if "%choice%"=="9" (
    %Education%
) else if "%choice%"=="10" (
    %Education_N%
) else if "%choice%"=="11" (
    %Enterprise_2015_LTSB%
) else if "%choice%"=="12" (
    %Enterprise_2015_LTSB_N%
) else if "%choice%"=="13" (
    %Enterprise_2016_LTSB%
) else if "%choice%"=="14" (
    %Enterprise_2016_LTSB_N%
) else (
    echo Invalid selection. Please enter a valid number.
    goto promptAndRun
)

pause
