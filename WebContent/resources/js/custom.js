$(document).ready(function() {
	      $(document).foundation();
	      
	      //add up to date copyright text to footer
	      var dates = new Date();
	      var thisYear = dates.getFullYear();
	      $('#footer').html('<h6 class="text-right">S&amp;R Administration | &copy; Stellr ' + thisYear + '</h6>');
	   })