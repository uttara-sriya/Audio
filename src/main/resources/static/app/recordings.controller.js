/**
 * Created by Sriya on 6/17/16.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .controller('RecordingsController',RecordingsController);

    RecordingsController.$inject=['$http'];
    function RecordingsController($http){
        var vm = this;
        vm.recordings=[];
        vm.getAll=getAll;
        vm.getStars=getStars;
        vm.deleteRecording=deleteRecording;

        init();

        function init(){
            getAll();
        }
        function getAll(){
         var url="/book/all/";
            var recordingPromise=$http.get(url);
            recordingPromise.then(function(response){
                vm.recordings=response.data;
            });
        }
        function getStars(){
            var url="/book/getStar/"+30;
            var recordingPromise=$http.get(url);
            recordingPromise.then(function(response){
                vm.recordings=response.data;
            });
        }
        function deleteRecording(id){
            var url="/book/delete/"+id;
            $http.post(url).then(function(response){
                vm.recordings=response.data;
            });

        }
    }
})();