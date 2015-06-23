angular.module('ngApp', []).controller('RecommendationsCtrl', function($scope, $http) {

    $http.postForm = function(url, data) {
        return $http({
            method: 'POST',
            url: url,
            data: data,
            headers: {
                'Content-Type': "application/x-www-form-urlencoded; charset=utf-8"
            },
            transformRequest: function(obj) {
                var str = [];
                for (var p in obj)
                    str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
                return str.join("&");
            }
        });
    };

    $scope.ignoreChannel = function(channel) {
        $http.postForm("ignoreChannel", {channel: channel}).success(window.location.reload());
    };

    $scope.ignoreShow = function(show) {
        $http.postForm("ignoreShow", {show: show}).success(window.location.reload());
    };

});