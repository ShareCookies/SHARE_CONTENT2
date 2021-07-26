#!/bin/bash
mkdir "test"
arrs=("zjfgw-finance-service" "zjfgw-personal-library-service" "major-urger-service" "zjfgw-equipment-service" "holiday-service" "zjsfgw-important-material-service" "zjsfgw-work-summary-service" "zjsfgw-e-government-service" "tool-box-service" "zjsfgw-special-work-service" "zjsfgw-check-team-service" "zjsfgw-party-work-service" "zjsfgw-woman-work-service" "zjsfgw-organize-work-service" "zjsfgw-youth-work-service" "examination-goabroad-service" "work-assessment-service" "zjfgw-informal-service" "org-doc-service")

for(( i=0;i<${#arrs[@]};i++)) do
#${#array[@]}获取数组长度用于循环
echo ${arrs[i]};
	cp "./"${arrs[i]}"/application.yml" "./test/"${arrs[i]}"application.yml"
done;