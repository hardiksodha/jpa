var scheduleCtrlFunction = function (dataService) {

    var vm = this;
    vm.myText = "I am in schedule controller";

    var paginationOptions = {
        pageNumber: 1,
        pageSize: 20,
        sort: null
    };

    // vm.selectedTeam = [];
    dataService.getSchedule(paginationOptions.pageNumber,
        paginationOptions.pageSize)
        .then(getScheduleSuccess)
        .catch(errorCallback);

    var columnDefs = [
        { name: 'firstTeam' },
        { name: 'secondTeam' },
        {name:'actionColumn'}

    ];
    vm.gridOptions = {
        paginationPageSizes: [20,40,60],
        paginationPageSize: paginationOptions.pageSize,
        enableColumnMenus:false,
        useExternalPagination: true,
        columnDefs: columnDefs,
        onRegisterApi: function(gridApi) {
            vm.gridApi = gridApi;
            gridApi.pagination.on.paginationChanged(
                null,
                function (newPage, pageSize) {
                    paginationOptions.pageNumber = newPage;
                    paginationOptions.pageSize = pageSize;
                    dataService.getSchedule(newPage,pageSize)
                        .then(getScheduleSuccess)
                        .catch(errorCallback)

                });
        }
    };

    vm.getCustomizedColumns= function(columnDefs){
        columnDefs.map(function(obj){
            if(obj.name==='actionColumn'){

                obj["cellTemplate"] = "<select><option selected value='{{row.entity.firstTeam}}'>{{row.entity.firstTeam}}</option><option value='{{row.entity.secondTeam}}'>{{row.entity.secondTeam}}</option></select>"

            }
        });

    }


    vm.getCustomizedColumns(columnDefs);


    function getScheduleSuccess(schedule) {
        // vm.scheduleList = schedule._embedded.schedule;
        // vm.gridOptions = {};

        vm.gridOptions.data = schedule._embedded.schedule;
        vm.gridOptions.totalItems = 56; //data.totalElements;

    }


    function getAllReadersComplete() {
        //console.log('getAllReaders has completed');
    }

    function errorCallback(errorMsg) {
        // console.log('Error Message: ' + errorMsg);
    }

    vm.getSelectedTeamNames = function(){
        alert(vm.selectedTeam);
    }



};
/**
 * Created by Hardik on 22-03-2017.
 */


myApp.controller('scheduleController',['dataService',scheduleCtrlFunction])