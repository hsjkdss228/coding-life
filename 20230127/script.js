jQuery(document).ready(() => {
  jQuery('#button').click(() => {
    jQuery('#output').text(
      jQuery('#input-name').val()
    )
  });
});
