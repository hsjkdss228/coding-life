import { serve } from 'https://deno.land/std@0.131.0/http/server.ts';

console.log('Function \'home\' up and running...');

serve(() => {
  try {
    return new Response(
      'Hello, world!',
      {
        headers: { 'Content-Type': 'text/plain' },
        status: 200,
      },
    );
  } catch (error) {
    return new Response(
      JSON.stringify(error.message),
      {
        headers: { 'Content-Type': 'application/json' },
        status: 400,
      },
    );
  }
});
